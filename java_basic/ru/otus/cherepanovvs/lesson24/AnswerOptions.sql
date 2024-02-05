CREATE TABLE AnswerOptions (
  answer_id INT PRIMARY KEY,
  question_id INT,
  answer_text TEXT,
  is_correct BOOLEAN,
  FOREIGN KEY (question_id) REFERENCES Questions(question_id)
);