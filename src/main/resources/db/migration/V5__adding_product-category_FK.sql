


ALTER TABLE product
    ADD CONSTRAINT fk_product_category
        FOREIGN KEY (category_id)
            REFERENCES category(id);
