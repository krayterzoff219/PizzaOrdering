<template>
	<select v-model="localObject">
		<option
			v-for="option of options"
			:key="option[keyProperty]"
			:value="option[valueProperty]">
			{{ option[textProperty] }}
		</option>
	</select>
</template>

<script>
export default {
	props: ["initialValue", "options", "keyProperty", "valueProperty"],
	data() {
		return {
			localObject: { ...this.initialObject },
		};
	},
	watch: {
		localObject(newValue) {
			// Emit an input event to the parent to update the parent component's value
			this.$emit("input", newValue);
		},
	},
};
</script>

<style></style>
