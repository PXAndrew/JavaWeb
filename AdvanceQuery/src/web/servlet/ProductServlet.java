package web.servlet;

import com.shopping.dao.IProductDAO;
import com.shopping.dao.IProductDirDAO;
import com.shopping.dao.impl.ProductDAOImpl;
import com.shopping.dao.impl.ProductDirDAOImpl;
import com.shopping.domain.Product;
import com.shopping.query.ProductQueryObject;
import com.shopping.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {

    private IProductDAO productDAO;
    private IProductDirDAO productdirDAO;

    @Override
    public void init() throws ServletException {
        productDAO = new ProductDAOImpl();
        productdirDAO = new ProductDirDAOImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");  // 接收 post 请求的参数编码
        String cmd = req.getParameter("cmd");
        if (cmd.equals("list")) {
            list(req, resp);
        }
    }


    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productDAO.query4(reqParamsToObject(req));
        req.setAttribute("products", products);
        req.setAttribute("productQueryObject", reqParamsToObject(req));
        req.getRequestDispatcher("/WEB-INF/product/views/productList.jsp").forward(req, resp);
    }

    private ProductQueryObject reqParamsToObject(HttpServletRequest request) {

        ProductQueryObject productQueryObject = new ProductQueryObject();
        if (StringUtil.hasLength(request.getParameter("name"))) {
            productQueryObject.setName(request.getParameter("name"));
        }

        if (StringUtil.hasLength(request.getParameter("minSalePrice"))) {
            productQueryObject.setMinSalePrice(new BigDecimal(request.getParameter("minSalePrice")));
        }

        if (StringUtil.hasLength(request.getParameter("maxSalePrice"))) {
            productQueryObject.setMaxSalePrice(new BigDecimal(request.getParameter("maxSalePrice")));
        }

        return productQueryObject;

    }
}
