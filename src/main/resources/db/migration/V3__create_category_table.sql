CREATE TABLE category (
                          id BIGINT PRIMARY KEY AUTO_INCREMENT,
                          title VARCHAR(255) NOT NULL,
                          meta_title VARCHAR(255) NOT NULL,
                          image LONGBLOB NOT NULL,
                          description TEXT NOT NULL,
                          parent_category_id BIGINT,
                          CONSTRAINT fk_parent_category
                              FOREIGN KEY (parent_category_id)
                                  REFERENCES category(id)
                                  ON DELETE CASCADE
);
