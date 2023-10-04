<template>
  
    <div id="order-items-view">
        <p>Item: {{menuItem.name}}</p>
        <br/>
        <p>Price: ${{menuItem.price}}</p>
        <br/>
        <p>Quantity: {{menuItem.quantity}}</p>
        <br/>
        <p>Order status: {{order.status}}</p>
        <br/>
        <p>Delivery or Pickup? {{order.isDelivery}}</p>
        <br/>
        <p>Customer phone number: {{order.phone}}</p>
        <br/>
        <p>Customer address: {{order.address}}</p>
        <br/>
    </div>


</template>

<script>
export default {

props: ["menuItem", "order"],

data(){

return{

    }
}

}
</script>

<style>

#order-items-view{
    border-bottom: black solid 3px;
   display: flex;
   flex-direction: row;
}
    

</style>