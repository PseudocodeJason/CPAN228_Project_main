# CPAN228_Project
testing
Add support to request items for Clothes WarehouseProject in the distribution centres
- As an administrator you should be able to see all distribution centres available to you, admin page can be augmented for this - 5%
- Distribution Centre Manager should be a separate Spring Boot Project as a REST API protected by basic web security(username/password) - 5%
- Distribution centre app should have following models:distribution centre (id, name, items available, latitude,longitude), Item (same as in clothes warehouse). Important:we should add quantity to the item model - 3%
- Distribution centre should expose following endpoints: add itemto distribution centre, delete item, list all distributioncentres, request item by brand and name - 7% # Done - Melody #
- Database interaction for all the above methods should besupported (included in 7% above)
- Create two Spring profiles for distribution centre with differentdata sources: H2 for dev and PostgreSQL for QA, pleaseuse Docker for Postgres DB and make sure that alloperations work correctly - 5%
- Create a form on the admin distribution centre page to requestitem by brand and name, logic should be the following(4%):
- Form contains two fields: name and brand dropdown and submitbutton
- On form submission we should check which distribution centrecontains items for these parameters
- Between centres with available items items should be requestedfrom the closest centre to the warehouse (warehouse shouldhave GTA area coordinates, exact location is up to you), youshould have at least 4 distribution centres and be able toclearly show me that logic works
- If successful, stock should be replenished in warehouse anddeducted from distribution centre from which we get theitem, else we are redirected to the error page that containsmessage that stock can’t be replenished- Add bootstrap styling to all components (1%)

Spring Initializr
![image](https://user-images.githubusercontent.com/32995324/229323795-ea937b64-6802-42e2-9164-4784f8210c52.png)
 
 ![image](https://user-images.githubusercontent.com/32995324/229535296-2381846e-cf9c-4d50-bf8a-ee72d1a446c0.png)

![image](https://user-images.githubusercontent.com/32995324/229535345-3983ccd0-051c-45f7-bd53-d3dfa7c01137.png)

 ![image](https://user-images.githubusercontent.com/32995324/229535388-a686075e-a97d-4d8f-92cc-3922ea33a1bc.png)

![image](https://user-images.githubusercontent.com/32995324/229535429-8eed3a16-2ce4-433e-80c4-837c1c9ae842.png)

 



