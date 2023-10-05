<template>
  
    <div class="order-items-view">
        
        <p><span>Item:</span> {{menuItem.name}}</p>
        
        <p><span>Quantity:</span> {{menuItem.quantity}}</p>
        
        <p><span>Size:</span> {{menuItem.pizza.size.name.charAt(0).toUpperCase() + menuItem.pizza.size.name.slice(1)}}</p>
        
        <p><span>Sauce:</span> {{menuItem.pizza.sauce.name.charAt(0).toUpperCase() + menuItem.pizza.sauce.name.slice(1)}}</p>
        
        <p><span>Crust:</span> {{menuItem.pizza.crust.name.charAt(0).toUpperCase() + menuItem.pizza.crust.name.slice(1)}}</p>
        
        <p><span>Topping{{itemToppings.split(",").length > 1 ? "s" : ""}}:</span> {{itemToppings}}</p>
        
        
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