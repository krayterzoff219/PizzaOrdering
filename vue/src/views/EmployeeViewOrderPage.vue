<template>
    


    <section id="employee-order-view-section">

         <horizontal-hero></horizontal-hero>
            <h2>Order Description</h2>
       
<<<<<<< HEAD
       <div id="order-details-wrapper">
            <horizontal-hero></horizontal-hero>
            <h2>Order View</h2>
            <div class = "information-section">

                <div class = "customer-info">
                    <p>Order status: {{currentOrder.status.charAt(0).toUpperCase() + currentOrder.status.slice(1)}}</p>
                    <br/>
                    <p>{{currentOrder.isDelivery ? "Delivery" : "Pick-up"}}</p>
                    <br/>
                    <p>Customer name: {{currentOrder.name}}</p>
                    <br/>
                    <p>Customer phone number: {{currentOrder.phone}}</p>
                    <br/>
                    <p>Customer address: {{currentOrder.address}}</p>
                    <br/>
                </div>
               
             

                <div class = "order-info">
                    <view-details-item
                    id="details-section"
                    v-for="Item of currentOrder.menuItems"
                    :key="Item.id"
                    :menuItem = "Item"
                    />
                    <view-details-custom-pizza
                    id="details-section"
                    v-for="pizza of currentOrder.customPizzas"
                    :key="pizza.id"
                    :pizza="pizza"
                    />
                    <br>
                    <br>
                    
                </div>

                <div id="view-order-total">
                    <p>Subtotal: ${{currentOrder.subtotal.toFixed(2)}}</p>
                    <p>Tax: ${{currentOrder.tax.toFixed(2)}}</p>
                    <br>
                    <p>Total: ${{(currentOrder.tax + currentOrder.subtotal).toFixed(2)}}</p>
                </div>

               
            </div>
=======
       <div class="title-section">
           
            <div class = "information-section-title">
                
                <p>Order status: </p>
                <br/>
                
                <p>Delivery or Pickup? </p>
                <br/>
                <p>Customer Name: </p>
                <br/>
                <p>Customer phone number: </p>
                <br/>
                <p>Customer address: </p>
                <br/>

            </div> 
                
            <div class = "information-section-title2">
                    <p>{{currentOrder.status.charAt(0).toUpperCase() + currentOrder.status.slice(1)}}</p>
                    <br/>
                    <p>{{currentOrder.isDelivery ? "Delivery" : "Pick-up"}}</p>
                    <br/>
                    <p>*Name goes here*{{currentOrder.name}}</p>
                    <br/>
                    <p>{{currentOrder.phone}}</p>
                    <br/>
                    <p>{{currentOrder.address}}</p>
                    <br/>
            </div>
       </div>
       <div class="pizza-detail-section">     
                <hr/>
            
                <view-details-item
                id="details-section"
                v-for="Item of currentOrder.menuItems"
                :key="Item.id"
                :menuItem = "Item"
                />
                <view-details-custom-pizza
                id="details-section"
                v-for="pizza of currentOrder.customPizzas"
                :key="pizza.id"
                :pizza="pizza"
                />
                
                <br>
                <div class="subtotal-section">
                <p>Subtotal: ${{currentOrder.subtotal.toFixed(2)}}</p>
                <br/>
                <p id="tax">Tax: ${{currentOrder.tax.toFixed(2)}}</p>
                <br/>
                <p>   Total: ${{(currentOrder.tax + currentOrder.subtotal).toFixed(2)}}   </p>
                </div>
           
>>>>>>> brock
            
            
               

            
       </div>

    </section>


</template>

<script>
import HorizontalHero from '../components/HorizontalHero.vue'
import ViewDetailsCustomPizza from '../components/ViewDetailsCustomPizza.vue'
import ViewDetailsItem from '../components/ViewDetailsItem.vue'



export default{

    components: {
        HorizontalHero, ViewDetailsItem,
        ViewDetailsCustomPizza
    },

    data(){
        return{
            currentOrder: {
                orderId: -1,
                name: "",
                status: "Pending",
                email: "",
                address: "test add",
                phone: -1,
                isDelivery: false,
                menuItems: {},
                customPizzas: {},
                subtotal: 0,
                tax: 0
            }
        }
    },

    created(){
        const order = this.$store.state.pendingOrders.filter(
            (myOrder) => myOrder.orderId == this.$route.params.id
        );
        this.currentOrder.orderId = order[0].orderId;
        this.currentOrder.status = order[0].status;
        this.currentOrder.email = order[0].email;
        this.currentOrder.address = order[0].address;
        this.currentOrder.phone = order[0].phone;
        this.currentOrder.isDelivery = order[0].isDelivery;
        this.currentOrder.menuItems = order[0].menuItems;
        this.currentOrder.customPizzas = order[0].customPizzas;
        this.currentOrder.subtotal = order[0].subtotal;
        this.currentOrder.tax = order[0].tax;
        this.currentOrder.name= order[0].name;

    }

}
</script>

<style scoped>

.title-section{
    display: flex;
    flex-direction: row;
    justify-content: space-evenly;
    width: 90%;
}


h2{
    text-decoration: underline;
    padding: 50px 40px ;
}

<<<<<<< HEAD
.information-section{
    display: grid;
    grid-template-columns: 1fr 1fr;
    grid-template-rows: 8fr 1fr;
    grid-template-areas:
    "customerInfo orderInfo"
    "total total";
=======
.information-section-title{
>>>>>>> brock
    padding-left: 30px;
    padding-right: 30px;
    padding-bottom: 10px;

}

.information-section-title2{
     padding-left: 30px;
    padding-right: 30px;
    padding-bottom: 10px;
}

.customer-info{
    grid-area: customerInfo;
}

.order-info{
    grid-area: orderInfo;
}

hr{
    width: 90%;
    height: 3px;
    
}

#tax{
    text-decoration: underline;
}

#details-section {
    
    border-bottom: black solid 1px;
    width: 90%;
    padding-left: 40px;
    margin: auto;
}

.subtotal-section{
    padding-bottom: 15px;
    margin-right: 100px;
    text-align: right;
    /* display: flex;
    flex-direction: row;
    justify-content: center; */
}



#view-order-total{
    display: flex;
    flex-direction: column;
    grid-area: total;
    align-items: end;
}

</style>
