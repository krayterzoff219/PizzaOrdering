<template>
	<section id="employee-order-view-section">
		<horizontal-hero></horizontal-hero>
		<div id="view-order-page-wrapper">
			<h1>Order Description</h1>

			<div class="title-section">
				<p>Order status:</p>
				<p>
					{{
						currentOrder.status.charAt(0).toUpperCase() +
						currentOrder.status.slice(1)
					}}
				</p>
				<p>Customer Name:</p>
				<p>{{ currentOrder.name }}</p>
				<p>Customer address:</p>
				<p>{{ currentOrder.address }}</p>
				<p>Delivery or Pickup?</p>
				<p>{{ currentOrder.isDelivery ? "Delivery" : "Pick-up" }}</p>
				<p>Customer Phone Number:</p>
				<p>{{ currentOrder.phone }}</p>
			</div>

			<div class="pizza-detail-section">
				<view-details-item
					v-for="Item of currentOrder.menuItems"
					:key="Item.id"
					:menuItem="Item" />

				<view-details-custom-pizza
					v-for="pizza of currentOrder.customPizzas"
					:key="pizza.id"
					:pizza="pizza" />

				<checkout-amount
					:omitButton="true"
					:givenTotal="`${(currentOrder.tax + currentOrder.subtotal).toFixed(
						2
					)}`"
					:givenTax="`${currentOrder.tax.toFixed(2)}`"
					:givenSubtotal="`${currentOrder.subtotal.toFixed(2)}`" />
			</div>
		</div>
	</section>
</template>

<script>
import CheckoutAmount from "../components/CheckoutAmount.vue";
import HorizontalHero from "../components/HorizontalHero.vue";
import ViewDetailsCustomPizza from "../components/ViewDetailsCustomPizza.vue";
import ViewDetailsItem from "../components/ViewDetailsItem.vue";

export default {
	components: {
		HorizontalHero,
		ViewDetailsItem,
		ViewDetailsCustomPizza,
		CheckoutAmount,
	},

	data() {
		return {
			currentOrder: {
				orderId: -1,
				name: "",
				status: "Pending",
				email: "",
				address: "",
				phone: -1,
				isDelivery: false,
				menuItems: {},
				customPizzas: {},
				subtotal: 0,
				tax: 0,
			},
		};
	},

	created() {
		if (!this.$store.state.pendingOrders.length) {
			this.$router.push({ name: "pending-orders" });
		}

		const order = this.$store.state.pendingOrders.filter(
			(myOrder) => myOrder.orderId == this.$route.params.id
		);

		if (!order) {
			this.$router.push({ name: "pending-orders" });
		}

		this.currentOrder.orderId = order[0].orderId;
		this.currentOrder.status = order[0].status;
		this.currentOrder.email = order[0].email;
		this.currentOrder.phone = order[0].phone;
		this.currentOrder.isDelivery = order[0].isDelivery;
		this.currentOrder.menuItems = order[0].menuItems;
		this.currentOrder.customPizzas = order[0].customPizzas;
		this.currentOrder.subtotal = order[0].subtotal;
		this.currentOrder.tax = order[0].tax;
		this.currentOrder.name = order[0].name;

		let string = order[0].address.split("|||");
		for (let i = 0; i < string.length; i++) {
			if (i == 0) {
				this.currentOrder.address = this.currentOrder.address + string[i];
			} else if (i == string.length - 1) {
				this.currentOrder.address =
					this.currentOrder.address + "\t" + string[i];
			} else {
				this.currentOrder.address =
					this.currentOrder.address + ", " + string[i];
			}
		}
	},
};
</script>

<style scoped>
.title-section {
	display: grid;
	grid-template-columns: 1fr 1fr;
	grid-template-rows: repeat(5, 1fr);
	width: 90%;
	margin: 0px auto;
	column-gap: 10px;
	row-gap: 10px;
	border-bottom: black solid 3px;
	padding-bottom: 20px;
}

.title-section p:nth-child(2n - 1) {
	justify-self: end;
	font-weight: bold;
	font-family: var(--loud-font-family);
}

.pizza-detail-section {
	width: 75%;
}

#view-order-page-wrapper {
	display: flex;
	flex-direction: column;
	align-items: center;
}
</style>

<style>
.order-items-view {
	display: flex;
	flex-direction: column;
	width: 100%;
	margin: 0 auto;
	padding-bottom: 15px;
	padding-top: 15px;
	row-gap: 5px;
	padding-left: 10px;
	padding-right: 10px;
}

.order-items-view {
	border-bottom: black solid 1px;
}
/* .order-items-view:not(:first-child) {
	border-top: black solid 1px;
} */

.order-items-view p span {
	font-weight: bold;
}
</style>
