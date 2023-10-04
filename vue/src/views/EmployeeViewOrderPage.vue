<template>
    


    <section id="employee-order-view-section">
       
       <div>
            <horizontal-hero></horizontal-hero>
            <h2>Order View</h2>

            <p>Order status: {{currentOrder.status.charAt(0).toUpperCase() + currentOrder.status.slice(1)}}</p>
            <br/>
            <p>{{currentOrder.isDelivery ? "Delivery" : "Pick-up"}}</p>
            <br/>
            <p>Customer phone number: {{currentOrder.phone}}</p>
            <br/>
            <p>Customer address: {{currentOrder.address}}</p>
            <br/>
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
            <p>Subtotal: ${{currentOrder.subtotal.toFixed(2)}}</p>
            <p>Tax: ${{currentOrder.tax.toFixed(2)}}</p>
            <br>
            <p>Total: ${{(currentOrder.tax + currentOrder.subtotal).toFixed(2)}}</p>
            


            
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

    }

}
</script>

<style scoped>


.details-section{
    
}

</style>
