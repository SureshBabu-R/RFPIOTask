Feature: Validate the add to cart and save for later functionality 
Scenario: Validate by adding the product to cart and save for later page and remove from it
Given  Launching of browser,managing window and opening the URL
When User should navigate to the Air freshner section coming under Home section
And User should navigate to the second page
And User should click the wishlist icon and confirm the message
And User should close the login page and move to the product page 
And User should enter the pincode and print the available delivery date
And User should add the item to the cart and confirm 
And User should increase the quantity from cart page and confirm the message
And User should click on save for later and validate
And User should remove the item from save for later 
Then Validate the confirmation message shown to user