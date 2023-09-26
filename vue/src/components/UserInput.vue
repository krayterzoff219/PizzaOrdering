<template>
	<div class="form-input-group">
		<label :for="inputId">{{ label }}</label>
		<input
			:type="inputType"
			:id="inputId"
			v-model="localValue"
			:autofocus="isAutofocus"
			:required="isRequired" />
	</div>
</template>

<script>
export default {
	props: ["label", "inputId", "inputType", "isAutofocus", "isRequired"],
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

<style scoped>
.form-input-group {
	margin-bottom: 1rem;
}
label {
	margin-right: 0.5rem;
}
</style>
