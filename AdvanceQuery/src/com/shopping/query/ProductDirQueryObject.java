package com.shopping.query;

import com.shopping.util.StringUtil;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductDirQueryObject extends QueryObject {

    private String dirName;

    @Override
    protected void customizedQuery() {
        if (StringUtil.hasLength(dirName)) {
            addQuery("dirName  LIKE ?", "%" + dirName + "%");
        }
    }
}
