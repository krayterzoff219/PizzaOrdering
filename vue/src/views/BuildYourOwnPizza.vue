<template>

	<section>
		<horizontal-hero></horizontal-hero>

		<build-your-own-pizza-category
		optionsCategory="crusts"
		v-model="crust"/>

		<build-your-own-pizza-category
		optionsCategory="toppings"
		v-model="toppings"
		isMultiple="true"
		/>

		<build-your-own-pizza-category
		optionsCategory="sauces"
		v-model="sauce"/>

		<build-your-own-pizza-category
		optionsCategory="sizes"
		v-model="size"/>


		
	</section>

</template>

<script>
import BuildYourOwnPizzaCategory from '../components/BuildYourOwnPizzaCategory.vue';
import HorizontalHero from '../components/HorizontalHero.vue';
import menuService from '../services/MenuService.js';


export default {

	components: {HorizontalHero, BuildYourOwnPizzaCategory},



data(){

	
	return {
		id:-this.$route.params.id, crust: -1, size: -1, toppings: [], sauce: -1,
	}

	

},

beforeCreate() {
        menuService.getPizzaOptions(); // TODO: .catch alert if error
    },
};
</script>

<style></style>
