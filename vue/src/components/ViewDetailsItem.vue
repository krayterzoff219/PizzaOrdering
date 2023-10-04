<template>
  
    <div id="order-items-view">
        <br>
        <br>
        <p>Item: {{menuItem.name}}</p>
        <br/>
        <p>Quantity: {{menuItem.quantity}}</p>
        <br/>
        <p>Size: {{menuItem.pizza.size.name.charAt(0).toUpperCase() + menuItem.pizza.size.name.slice(1)}}</p>
        <br/>
        <p>Sauce: {{menuItem.pizza.sauce.name.charAt(0).toUpperCase() + menuItem.pizza.sauce.name.slice(1)}}</p>
        <br/>
        <p>Crust: {{menuItem.pizza.crust.name.charAt(0).toUpperCase() + menuItem.pizza.crust.name.slice(1)}}</p>
        <br/>
        <p>Toppings: {{itemToppings}}</p>
        <br/>
        
    </div>


</template>

<script>
export default {

props: ["menuItem", "order"],

data(){

return{

    }
},

computed: {
    itemToppings(){
        let toppingList = '';
        const toppings = this.menuItem.pizza.toppings;
        if(toppings.length != 0){
            toppingList = toppingList + toppings[0].name.charAt(0).toUpperCase() + toppings[0].name.slice(1);
            for (let i = 1; i < toppings.length; i++){
                toppingList = toppingList + ', ' + toppings[i].name.charAt(0).toUpperCase() + toppings[i].name.slice(1);
            }
        }
        return toppingList;
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