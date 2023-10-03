<template>
	<div class="build-your-own-pizza-category-wrapper">
		<!-- prettier-ignore -->
		<h2>Choose your <span>{{
            optionsCategory.charAt(0).toUpperCase() + (
                isMultiple 
                    ? optionsCategory.slice(1) 
                    : optionsCategory.slice(1, -1)
            )
        }}</span>:</h2>
		<div class="pizza-option-inputs-wrapper">
			<template v-for="option of $store.state[optionsCategory]">
				<div
					class="pizza-option-single-input-wrapper"
					v-if="option.isAvailable"
					:key="option.id">
					<input
						:id="`${option.name
							.replace(' ', '-')
							.toLowerCase()}-${optionsCategory}`"
						:required="!isMultiple"
						:type="isMultiple ? 'checkbox' : 'radio'"
						:name="optionsCategory"
						:value="option.id"
						v-model="userOption"
						:selected="userOption === option.id"
						:checked="userOption === option.id" />

					<label
						:for="`${option.name
							.replace(' ', '-')
							.toLowerCase()}-${optionsCategory}`"
						>{{ option.name }} (${{ option.price.toFixed(2) }})</label
					>
				</div>
			</template>
		</div>
	</div>
</template>

<script>
export default {
	props: ["optionsCategory", "isMultiple", "defaultValue"],
	data() {
		return {
			userOption: [],
		};
	},
	created() {
		if (this.defaultValue) {
			this.userOption = this.defaultValue;
		}
	},
	watch: {
		userOption(newValue) {
			// Emit an input event to the parent to update the parent component's value
			this.$emit("input", newValue);
		},
	},
};
</script>

<style scoped>
div.pizza-option-inputs-wrapper {
	display: flex;
	flex-wrap: wrap;
	row-gap: 8px;
	width: 100%;
	justify-content: flex-start;
}

div.pizza-option-single-input-wrapper {
	padding-right: 20px;
	flex: 1;
	flex-basis: 8rem;
	max-width: 33%;
	min-width: max-content;
}

h2 {
	padding-bottom: 0.75rem;
}

h2 span {
	color: var(--primary-color);
	font-weight: bold;
}
</style>
