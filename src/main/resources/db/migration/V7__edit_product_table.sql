

ALTER TABLE product
    ADD COLUMN brand_id BIGINT NOT NULL ;


ALTER TABLE product
    ADD CONSTRAINT fk_product_brand
        FOREIGN KEY (brand_id) REFERENCES product_brand (id);