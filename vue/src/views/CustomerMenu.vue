<template>
	<section
		id="menu-section"
		class="customer-section">
		<horizontal-hero :transparentBackground="true" />
		<div class="menu-wrapper">
			<h1>Menu</h1>
			<p class="hero-text">
				<span>The BEST Pizza in Town -</span> Indulge in a taste sensation like
				no other. Our pizzas are expertly handcrafted with the finest, freshest
				ingredients, creating a symphony of flavors that dance on your palate.
				From our secret sauce to our meticulously sourced toppings, every bite
				is a journey of culinary delight that sets us apart from the rest.
			</p>
			<an-alert
				v-if="alertText"
				:message="alertText" />
			<menu-item />
			<!-- Build your own pizza option -->
			<menu-item
				v-for="pizza of $store.state.specialtyPizzas"
				:key="pizza.id"
				:menuItem="pizza" />
		</div>
	</section>
</template>

<script>
import AnAlert from "../components/AnAlert.vue";
import HorizontalHero from "../components/HorizontalHero.vue";
import MenuItem from "../components/MenuItem.vue";
import menuService from "../services/MenuService.js";

export default {
	components: {
		AnAlert,
		HorizontalHero,
		MenuItem,
	},
	name: "customer-menu",
	data() {
		return {
			alertText: "",
		};
	},
	beforeCreate() {
		menuService.getPizzaOptions(); // TODO: .catch alert if error
		menuService.getMenuItems(); // TODO: .catch alert if error
	},
};
</script>

<style scoped>
section.customer-section#menu-section {
	background-image: url("https://img.freepik.com/premium-vector/pizza-seamless-pattern_373337-10.jpg?w=826");
}

section.customer-section#menu-section div.menu-wrapper {
	display: flex;
	flex-direction: column;
	max-width: 50rem;
	border: 5px solid var(--dark-color);
	margin-bottom: 75px;
}
/*    ^ about this border
      ^ 
The the element ends up being 800px wide exactly with the borders included,
and when the side borders touch the outer margin of the page it looks a little
clunky. Because the element's width is maxed out at 97% of the screen,
a screen width of 825px is where the element's side borders meet the 
outer margin (800 / .97 = 825). The borders are dropped on the sides when
the screen is smaller than 825 and kept when the screen is larger than 825. 
*/
@media only screen and (max-width: 825px) {
	section.customer-section#menu-section div.menu-wrapper {
		border-right: none;
		border-left: none;
		border-radius: 15px;
	}
}

p.hero-text {
	text-align: justify;
	max-width: 40em;
	margin-right: auto;
	margin-left: auto;
	margin-bottom: 30px;
	padding: 20px;
	border-bottom: 3px solid var(--dark-color);
	border-top: 3px solid var(--dark-color);
	line-height: 1.3;
}

p.hero-text span {
	color: var(--primary-color);
	font-family: var(--loud-font-family);
}

h1 {
	padding-top: 10px;
}

h1 {
	width: 100%;
}

@media only screen and (min-width: 500px) {
	section.customer-section#menu-section div.menu-wrapper {
		display: flex;
		flex-wrap: wrap;
		flex-direction: row;
	}
}

@media only screen and (min-width: 768px) {
	section.customer-section#menu-section div.menu-wrapper {
		flex-direction: column;
	}
}
</style>
