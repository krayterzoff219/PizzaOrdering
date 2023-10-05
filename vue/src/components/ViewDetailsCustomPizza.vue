<template>
  
    <div class="order-items-view">
        
        
        <p><span>Item:</span> Custom Pizza</p>
        
        <p><span>Quantity:</span> {{pizza.quantity}}</p>
        
        <p><span>Size:</span> {{pizza.size.name.charAt(0).toUpperCase() + pizza.size.name.slice(1)}}</p>
        
        <p><span>Sauce:</span> {{pizza.sauce.name.charAt(0).toUpperCase() + pizza.sauce.name.slice(1)}}</p>
        
        <p><span>Crust:</span> {{pizza.crust.name.charAt(0).toUpperCase() + pizza.crust.name.slice(1)}}</p>
        
        <p><span>Topping{{itemToppings.split(",").length > 1 ? "s" : ""}}:</span> {{itemToppings}}</p>
        
        
    </div>


</template>

<script>
export default {

props: ["pizza"],

data(){

return{

    }
},

computed: {
    itemToppings(){
        let toppingList = '';
        const toppings = this.pizza.toppings;
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

