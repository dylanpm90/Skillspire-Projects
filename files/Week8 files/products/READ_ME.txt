Customer to Address is a OneToOne relationship since a customer only has one address.

Customer to Order has a OneToMany relationship since customers can make multiple orders.

Order to Product has a ManyToMany relationship since many products can be on many orders and vice versa.

Order to Customer has a ManyToOne relationship because the customer can make multiple orders.

