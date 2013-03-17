##UniHub

###Summary
Our web application, project UniHub, will be an online classified listing service specifically geared towards the college ecosystem. Only users with a valid university email address will be allowed to register. The application will allow users to both browse and provide listings. Postings will be made specific to a University area and users will be able to view postings filtered to a specific university or area. In addition to filtering search queries by location, users will also be able to classify and view postings according to category. These listings can contain any number of things, from books to used furniture or cars and bicycles. Essentially, the items we expect to be posted on our website will be those that are essential to the college lifestyle. Users who are not members will be able to view listings but will not be able to post items, message members or interact in comment feeds.
Each specific item posting will also have a messaging forum located directly underneath the items description so to encourage dialogue between buyers and seller. In addition to this, there will also be a private messaging service to provide a medium for private dialogue. An item for sale can be posted in one of two modes: with a static price or with a bidding mode. Bidding mode allows the seller to specify a starting price and buyers will be able to bid on the item in the increments that the buyer chooses. Selling mode and bidding increments will be specified by the seller in a form when he or she is posting the item for sale. Items for sale may have one of two states: available and sold. Items in the available state will be available for search query. Items in the sold state will not. There will be two views for an item being sold; one meant for the seller and one meant for the buyer. The seller will be able to click a sold button that will change the items state to sold. The sold item will then be stored in an accessible portion of the site where the seller will be able to view the history of their sold items and change the state of an item back to available if need be.
	UniHub will also implement a reputation points system in order to allow buyers and sellers to gain credibility. After a sales transaction is made(an item changes to the sold state), a buyer may award a seller one point for good business and vice-versa.
	UniHub is targeted for local region transactions. Therefore, we do not promote sellers to ship any items nor will we supply any services for payment, package tracking or things of that nature. If the item that the user is looking for is not for sale in his or her region we will automagically show the user results for their query through the API’s of other services. This simplifies their work and keeps them coming back for more.

###Target

The college ecosystem (students, faculty, alumni...)
Local area transactions

###Back end 

User Authentication system 
Users must have a .edu email
Database management (profiles, listings, messages, other content)
Email notification
For when the user receives personal messages or postings on a item for sale
Points of Contact
 Consume: {(Books) Half.com, Amazon, Chegg, Barnes & Nobles}, Craigslist Listings, GoogleMaps (to show locations)
 Produce: Listing data sorted by filter

##Web Tier
Custom home page when logged in
Listings pages
User Pages - Sign Up, Log In Profile Views
Post and view items

Messaging Feature
Personal messaging form
Item comment feed
Search query feature
Sort results by region (users’ university region will be default region)
 Sort results by category (these will be static not user-defined)
Tab for search results from our service
Tab for Craigslist results using university region
Tab for eBay results using university region

Aggregator of query from other services (such as Amazon and such...) 
supplies users with alternative services in case item is not found on ours

###Platform
Maven Build Management System
The application will be deployed in JBoss AS
The main language utilized will be Java
All database work will be done in MySQL 

###Labor
Group: Andy Valdez, Delvison Castillo, Mark Willson, Yulle Borges 
