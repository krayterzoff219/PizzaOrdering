<template>
	<div class="form-input-group">
		<label :for="inputId">{{ label }}</label>
		<input
			:type="inputType"
			:id="inputId"
			v-model="localValue" />
	</div>
</template>

<script>
export default {
	props: ["label", "inputId", "inputType"],
	data() {
		return {
			localValue: "",
		};
	},
	watch: {
		localValue(newValue) {
			// Emit an input event to the parent to update the parent component's value
			this.$emit("input", newValue);
		},
	},
};
</script>
