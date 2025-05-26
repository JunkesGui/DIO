
# Challenge 1: Bank account

A bank account wich can perform the following operations:
-
- Consult Balance
- Consult Overdraft Protection
- Deposit
- Withdraw
- Pay a bill
- Verify if it using Overdraft Protection

Implementation rules:
-
- The Overdraft Protection must be added to the account Balance
- The Overdraft Protection value is defined at the account creation, according to the first deposit:
    - If the deposit at the account creation is less or equals than $500,00, the Overdraft Protection will be $50,00
    - Deposits greater than $500,00 must be 50% of the deposit value
    - In case of Overdraft Protection use, the account must charge a 20% fee over the Overdraft value.