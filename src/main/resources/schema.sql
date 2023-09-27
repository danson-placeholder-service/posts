CREATE TABLE IF NOT EXISTS Post (
   id INT NOT NULL,
   user_id INT NOT NULL,
   title varchar(250) NOT NULL,
   body text NOT NULL,
   version int,
   PRIMARY KEY (id)
);