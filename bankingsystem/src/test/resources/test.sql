TRUNCATE bank_accounts CASCADE;

INSERT INTO bank_accounts (bank_account_id, open_date, account_number, balance, deleted, percentage, capitalization,
account_credit, account_debit, credit, version) VALUES (1, '2014-05-24 20:45:00','PL83172971532576629824360301', 100.0,
false, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0);
INSERT INTO bank_accounts (bank_account_id, open_date, account_number, balance, deleted, percentage, capitalization,
account_credit, account_debit, credit, version) VALUES (2, '2014-05-24 20:45:00','PL83172971532576629824360302', 100.0,
false, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0);

ALTER SEQUENCE bank_account_seq RESTART WITH 3;
