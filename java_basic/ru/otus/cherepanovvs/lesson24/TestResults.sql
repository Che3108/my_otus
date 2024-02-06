CREATE TABLE TestResults (
  result_id INT PRIMARY KEY,
  test_id INT,
  student_name VARCHAR(255),
  student_surname VARCHAR(255),
  test_date DATE,
  FOREIGN KEY (test_id) REFERENCES Tests(test_id)
);