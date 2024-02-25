# TeachMeSkills_C27_Lesson_14_HW

App allows user analyze .txt files with document numbers. During run app read test_document.txt file or
any other .txt file with path which user enter. App analyzes each line in .txt document and validate the value of
the line.

If the value matches next rules:
1. Document number must be 15 characters long;
2. Starts with the sequence docnum or contract;
3. And contains only letters or numbers without any other chars (checking by regex);
then app write valid doc numbers to next .txt files: valid_document.txt or valid_contract.txt.

If the value does not match rules above app writes this value to invalid_document.txt files and append
the reason why this value is not valid.
