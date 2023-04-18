# CPAN228_Project
testing
Add support to request items for Clothes WarehouseProject in the distribution centres
- As an administrator you should be able to see all distribution centres available to you, admin page can be augmented for this - 5% # Done - Jason #
- <del>Distribution Centre Manager should be a separate Spring Boot Project as a REST API protected by basic web security(username/password) - 5% # Deleted by the teacher # </del>
- Distribution centre app should have following models:distribution centre (id, name, items available, latitude,longitude), Item (same as in clothes warehouse). Important:we should add quantity to the item model - 3% # Done - Melody #
- Distribution centre should expose following endpoints: add item to distribution centre, delete item, list all distributioncentres, request item by brand and name - 7% # Done - Melody #
- Database interaction for all the above methods should besupported (included in 7% above) # Done - Melody #
- <del> Create two Spring profiles for distribution centre with differentdata sources: H2 for dev and PostgreSQL for QA, pleaseuse Docker for Postgres DB and make sure that alloperations work correctly - 5% # Deleted by the teacher #</del>
- Create a form on the admin distribution centre page to requestitem by brand and name, logic should be the following(4%): # Doing - Mohammed #
- Form contains two fields: name and brand dropdown and submitbutton # Doing - Mohammed #
- On form submission we should check which distribution centrecontains items for these parameters
- Between centres with available items items should be requestedfrom the closest centre to the warehouse (warehouse shouldhave GTA area coordinates, exact location is up to you), youshould have at least 4 distribution centres and be able toclearly show me that logic works # Doing - Mohammed #
- If successful, stock should be replenished in warehouse anddeducted from distribution centre from which we get theitem, else we are redirected to the error page that containsmessage that stock can’t be replenished- Add bootstrap styling to all components (1%)

Spring Initializr
![image](https://user-images.githubusercontent.com/32995324/229323795-ea937b64-6802-42e2-9164-4784f8210c52.png)
 
 
list all distributioncentres
![image](https://user-images.githubusercontent.com/32995324/232350343-e48db9ce-eab3-48c5-991b-e14526e32694.png)


![image](https://user-images.githubusercontent.com/32995324/232350355-7bc61be3-fef6-4099-8c16-80bdd4470029.png)

delete item
![image](https://user-images.githubusercontent.com/32995324/232350365-5aca5413-d1cf-4986-a7a0-81ab4f109d8d.png)

add item to distribution centre
![image](https://user-images.githubusercontent.com/32995324/232350375-f4d9eaa0-6dfc-4522-aec8-07de596a3af2.png)

request item by brand 

http://localhost:8082/api/DistributionCentre/1/items/by-brand/Balenciaga

![image](https://user-images.githubusercontent.com/32995324/232350508-06c45529-eecd-4cdf-94fe-a03ebe6c0b5a.png)


request item by name

http://localhost:8082/api/DistributionCentre/1/items/by-name/T-Shirt

![image](https://user-images.githubusercontent.com/32995324/232350476-eb5b348a-bda7-4a78-8b3a-8e5873c150a3.png)

