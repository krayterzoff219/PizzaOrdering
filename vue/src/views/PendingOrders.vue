<template>
	<section
		id="pending-orders"
		class="employee-section">
		<horizontal-hero></horizontal-hero>
		<div class="pending-order-wrapper">
			<h1>Pending Orders</h1>
			<order-item
			v-for="order of pendingOrders"
			:key="order.id"
			:order="order"
			/>
		</div>
		
	</section>
</template>

<script>
import HorizontalHero from "../components/HorizontalHero.vue";
import OrderService from '../services/OrderService';
import OrderItem from '../components/OrderItem';


export default { 

  components: { HorizontalHero, OrderItem},

	name: "pending-orders",
	
	beforeCreate() {
		if (Object.keys(this.$store.state.cart).length) {
			this.$store.commit("CLEAR_CART");
		}
		OrderService.getPendingOrders()
	},
	destroyed(){
		this.$store.commit("LOAD_PENDING_ORDERS")
	}




};
</script>
