package org.selenium.pom.Objects;

import org.selenium.pom.utils.JacksonUtils;

import java.io.IOException;

public class Products {

    private int id;
    private  String productName;




    public   Products(int id) throws IOException
    {
        Products Products[]=JacksonUtils.Fileloader("Products.json",Products[].class );


        for (Products product:Products)
        {

                this.id=product.id;
                this.productName=product.productName;

        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }






}


