CREATE TABLE Questions (
  question_id INT PRIMARY KEY,
  test_id INT,
  question_text TEXT,
  FOREIGN KEY (test_id) REFERENCES Tests(test_id)
);