<template>
    


    <section id="employee-order-view-section">
       
       <div>
            <horizontal-hero></horizontal-hero>
            <h2>Order View</h2>
            <p>{{currentOrder.status}}</p>
            <p>{{currentOrder.address}}</p>
            <p>{{currentOrder.menuItems}}</p>
       </div>

    </section>


</template>

<script>
import HorizontalHero from '../components/HorizontalHero.vue'


export default{

    components: {
        HorizontalHero
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
        console.log(this.$store.state.pendingOrders);
        const order = this.$store.state.pendingOrders.filter(
            (myOrder) => myOrder.orderId == this.$route.params.id
        );
        console.log(order);
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

</style>
