Feature: Card Spending Integration
  Only accredited systems may include new expenses.
  A volume of 100,000 inclusions per second is expected
  Expenses will be informed through the JSON protocol, following the pattern:
    {"description": "alphanumeric", "value": double american, "alias": numeric, "date": UTC format date}
	
Feature: Spend Listing *
  Given that access as an authenticated customer who can view card spend
  When I access the spend listing interface
  So I would like to see my most current expenses. 
* This feature expects 2,000 hits per second.
* Customer expects to see spend 5 seconds ago.

Feature: Spend Filter
  Given that access as an authenticated client
  And I went to the spend listing interface
  And set the date filter to 3/27/1992
  So I would like to see my spending just for this day.  
  
Feature: Expense Categorization
  Given that access as an authenticated client
  When I access the detail of an expense
  And this one doesn't have a category
  Then I should be able to include a category for this  
  
Feature: Category Suggestion
  Given that access as an authenticated client
  When I access the detail of expense that has no category
  And I start typing the category I want
  Then a list of category suggestions should be displayed, based on categories already reported by other users.
  
Feature: Automatic Spending Categorization
  In the spend integration process, the category should be automatically included.
  if the description of an expense equals the description of any other expense already categorized by the customer
  it should receive this category at the time of inclusion
  
