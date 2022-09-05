DROP TABLE IF EXISTS contacts;
CREATE TABLE contacts (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL
);
INSERT INTO contacts (first_name, last_name, email) VALUES
  ('Laurent', 'GINA', 'laurentgina@mail.com'),
  ('Sophie', 'FONCEK', 'sophiefoncek@mail.com'),
  ('Agathe', 'FEELING', 'agathefeeling@mail.com');