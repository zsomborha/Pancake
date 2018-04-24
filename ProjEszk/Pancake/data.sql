CREATE TABLE IDSEQUENCE(
	VAL BIGINT
);

CREATE TABLE QUESTION(
      ID BIGINT PRIMARY KEY,
      QUESTION_STRING VARCHAR(80) NOT NULL,
      CORRECT_ANSWER VARCHAR(80) NOT NULL,
      INCORRECT_ANSWER_1 VARCHAR(80) NOT NULL,
      INCORRECT_ANSWER_2 VARCHAR(80) NOT NULL,
      INCORRECT_ANSWER_3 VARCHAR(80) NOT NULL
);

INSERT INTO IDSEQUENCE (VAL) VALUES (1000);

INSERT INTO QUESTION (ID, QUESTION_STRING, CORRECT_ANSWER, INCORRECT_ANSWER_1, INCORRECT_ANSWER_2, INCORRECT_ANSWER_3) 
VALUES (1, 'Whose final film as director was Eyes Wide Shut?', 'Stanley Kubrick', 'David Kronenberg', 'Alfred Hitchcock', 'Orson Welles'); 
INSERT INTO QUESTION (ID, QUESTION_STRING, CORRECT_ANSWER, INCORRECT_ANSWER_1, INCORRECT_ANSWER_2, INCORRECT_ANSWER_3) 
VALUES (2, 'Which year was the Unix operating system implemented in?', '1969', '1956', '1973', '1984');