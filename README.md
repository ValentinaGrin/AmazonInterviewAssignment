#Installation of the project
1. Created new Maven project
2. Installed all dependencies
3. In src/test/java created 3 packages: Pages, TestCases, and utilities
4. In Pages, created classes with pages that have been used for the tests
5. In TestCases, created one test class where the test cases will be written and run
6. In utilities, created ConfigurationReader and Driver classes
7. In configurations.properties, the browser was set as 'edge' (had issues with running in Chrome due to version updates)

#Project Overview
In TestCases, AmazonTest class, two @Tests were created.

addProductToCart method: test searches for a specific product by name. Randomly selects a product within that category and
validates that product was added to cart by "Added to Cart" header present.

searchProductByASIN method: test searches the product by the ASIN number, validates that the product name/description
matches with the expected ASIN number. Then, the test selects that product and validates that product details (ProductPage)
lists the same ASIN number in the "Additional Information" table.

Within the AmazonTest class, private helper methods were created for code readability, maintainability, and improved test structure.