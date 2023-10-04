<template>
    


    <section id="employee-order-view-section">
       
       <div>
            <horizontal-hero></horizontal-hero>
            <h2>Order View</h2>

            <div class="information-section">
                <p>Order status: {{currentOrder.status.charAt(0).toUpperCase() + currentOrder.status.slice(1)}}</p>
                <br/>
                <p>{{currentOrder.isDelivery ? "Delivery" : "Pick-up"}}</p>
                <br/>
                <p>Customer phone number: {{currentOrder.phone}}</p>
                <br/>
                <p>Customer address: {{currentOrder.address}}</p>
                
                <hr/>
                

                <view-details-item
                id="details-section"
                v-for="Item of currentOrder.menuItems"
                :key="Item.id"
                :menuItem = "Item"
                />
            </div>

           
               
        </div>

    </section>


</template>

<script>
import HorizontalHero from '../components/HorizontalHero.vue'
import ViewDetailsItem from '../components/ViewDetailsItem.vue'



export default{

    components: {
        HorizontalHero, ViewDetailsItem
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
                customPizzas: {}
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

    }

}
</script>

<style scoped>

h2{
    text-decoration: underline;
    padding: 20px;
}

.information-section{
    padding-left: 30px;
    padding-right: 30px;
    
}

hr{
    width: 100%;
    height: 3px;
    
}

#details-section {
    border-bottom: black solid 1px;
}


</style>
