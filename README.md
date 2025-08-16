# Dashboard-Backend

# Enpoints
### offers
- getAllOffers

### opinions
- getOpinionsByUserId

### orders
- getOrderStatussesNumbers

### users
- getUserScore
- getUserAspects

### sales
- getSalesStatistics

  
# Object examples

### aspects
{ id: 1, aspect: "Communication", points: 8, scale: 10, userId: 1 },

### offer
 {
      userId: 1,
      name: "Fresh Bread",
      revenue: "149.99",
      units: 120,
      numberOfViews: 345,
      pictureAddr: "/bread.jpg"
},
### opinions
{
    {userId:1, productName: "Chleb", rate: 5, description: "Świetny produkt!" },
}
### orders
{
    id: 1,
    productId: 1,
    date: "15/12/2024",
    status: "unPaid",
    price: "149.99",
    userId: 1,
  },
