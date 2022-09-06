DROP TABLE IF EXISTS contacts;
CREATE TABLE contacts (
  id LONG AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL
);
INSERT INTO contacts (first_name, last_name, email) VALUES
  ('Laurent', 'AAA', 'laurent@mail.com'),
  ('Mickael', 'BBB', 'micka@mail.com'),
  ('David', 'CCC', 'david@mail.com');