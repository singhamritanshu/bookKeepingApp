# bookKeepingApp
A book keeping app with mysql database.

The following end points are exposed:
1) @PostMapping("/createTable/{table_name}")- To create a table in the database.

<img width="1299" alt="createTable" src="https://user-images.githubusercontent.com/64220796/125249356-c7723800-e312-11eb-9c92-b77016c746e2.png">

2) @PostMapping("/saveBook")- To save a book book in the database.

<img width="1300" alt="saveBook" src="https://user-images.githubusercontent.com/64220796/125249383-cfca7300-e312-11eb-9f77-e57775040c1c.png">

3) @GetMapping("/getAllBooks")- To display all the books in the database.

<img width="1299" alt="getAllBooks" src="https://user-images.githubusercontent.com/64220796/125249431-dbb63500-e312-11eb-91c9-05f6ca1e6bd1.png">

4) @GetMapping("/getBook")- To search a book by book name.

<img width="1296" alt="getBook" src="https://user-images.githubusercontent.com/64220796/125249447-df49bc00-e312-11eb-9c90-98059923cd19.png">
