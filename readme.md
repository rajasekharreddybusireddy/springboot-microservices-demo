post-http://localhost:8082/order/bookOrders
body---
{
	"order":{
	"name":"mobile",
	"qty":4,
	"price":110
	},
	"payment":{	}

}
======================================
get-http://localhost:8082/order/getAllOrders

get-http://localhost:8082/payment/{orderId}
