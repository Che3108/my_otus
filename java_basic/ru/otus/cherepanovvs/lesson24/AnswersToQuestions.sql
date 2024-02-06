CREATE TABLE AnswersToQuestions (
  answer_id INT PRIMARY KEY,
  result_id INT,
  question_id INT,
  selected_answer_id INT,
  FOREIGN KEY (result_id) REFERENCES TestResults(result_id),
  FOREIGN KEY (question_id) REFERENCES Questions(question_id),
  FOREIGN KEY (selected_answer_id) REFERENCES AnswerOptions(answer_id)
);