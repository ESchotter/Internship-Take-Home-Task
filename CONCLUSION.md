# Conclusion for TICKET-101

Decision engine works according to requirements:
- if there is invalid personal code in request, decision engine returns error message "Invalid personal ID code!"
- if person, who is applying for loan has dept, decision engine returns 
negative decision with error message "No valid loan found!"
- decision engine returns maximum loan amount for the person, regardless of the requested loan amount
- if no suitable loan amount can be found with selected loan period,
decision engine increases loan period until there is possible loan amount
- if in previous calculation loan period exceeds maximum loan period determined by constraints
engine returns error message "No valid loan found!"
- if requested loan period is under minimum or over maximum loan period determined by constraints
engine returns error message "Invalid loan period!"
- if requested loan amount is under minimum or over maximum loan amount determined by constraints
engine returns error message "Invalid loan amount!"
- in calculating maximum loan amount for the person, decision engine uses that person's credit modifier

Even though there isn't used exactly same formula for calculating credit score that was given in task requirements, 
method used in decision engine to check if it should be approved
- credit modifier * loan period < minimum loan amount;

is doing mathematically same thing as comparing credit score with 1
- (credit modifier / minimum loan amount) * loan period < 1;

Overall seems that code behaves as it should according to task requirements and intern has even added tests to make sure
that it does.

What considers code readability and maintainability, it is very well-structured. Constrains and credit modifiers
are held separately from the code and if necessary can be changed without changing decision engine. Intern made custom 
exceptions that are also separated from teh code. Inside the decision engine methods are fairly short and perform single
task. It is also great that intern used external solution for validating Estonian personal code, but it comes with a 
minor risk as the author of the solution can decide to remove it from the GIT at some point in time (especially as 
it seems that this external solution is written by SEB Pank AS employee). If there is something that I would improve,
is that decision engine both calculates loan amount and period and also validates inputs. I would separate calculation 
and validation of inputs so if in the future there would be additional validation requirements, it wouldn't be necessary 
to modify part that is responsible for calculations.
