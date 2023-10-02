<template>
	<div class="options-category-wrapper">
		<h2>
			{{ optionsCategory.charAt(0).toUpperCase() + optionsCategory.slice(1) }}
		</h2>
		<pizza-option-row
			v-for="option of $store.state[optionsCategory]"
			:key="option.id"
			:option="option"
			:optionsCategory="optionsCategory"></pizza-option-row>
		<!-- new option row--><pizza-option-row
			key="new"
			:optionsCategory="optionsCategory"></pizza-option-row>
	</div>
</template>

<script>
import PizzaOptionRow from "./PizzaOptionRow.vue";
export default {
	components: { PizzaOptionRow },
	name: "pizza-options-category",
	props: ["optionsCategory"],
};
</script>

<style scoped>
section.employee-section div.options-category-wrapper {
	width: 100%;
	max-width: 30rem;
	margin-right: auto;
	margin-left: auto;
}

section.employee-section div.options-category-wrapper:not(:last-child) {
	margin-bottom: 3rem;
}

h2 {
	margin-bottom: 0.5rem;
}
</style>
