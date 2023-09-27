<template>
	<div role="alert">{{ message }}</div>
</template>

<script>
export default {
	props: ["message"],
};
</script>

<style scoped>
div[role="alert"] {
	margin-bottom: 1.5rem;
	color: var(--primary-color);
}
</style>
