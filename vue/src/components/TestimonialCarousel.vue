<template>
	<div class="testimonial-carousel">
		<div id="quotation-marks"><i class="fa-solid fa-quote-left"></i></div>
		<template v-for="(testimonial, index) in testimonials">
			<div
				class="testimonial-text-wrapper"
				:key="`${index}-text-wrapper`"
				v-show="index === currentIndex">
				<p
					:key="`${index}-text`"
					class="testimonial-text">
					{{ testimonial.text }}
				</p>
			</div>
			<p
				:key="`${index}-author`"
				v-show="index === currentIndex"
				class="testimonial-author">
				- {{ testimonial.author }} -
			</p>
		</template>
		<div class="carousel-buttons">
			<i
				@click="prev"
				class="fa-solid fa-angle-left"></i>

			<i
				class="fa-circle carousel-dot"
				:class="{
					'fa-solid': index === currentIndex,
					'fa-regular': index !== currentIndex,
				}"
				v-for="(testimonial, index) in testimonials"
				:key="index"></i>

			<i
				@click="next"
				class="fa-solid fa-angle-right"></i>
		</div>
	</div>
</template>

<script>
export default {
	name: "testimonial-carousel",

	data() {
		return {
			currentIndex: 0,
			testimonials: [
				{
					text: "Wow, I can't get enough of the mouthwatering pizzas from UpperCrust Pizza. Each slice is a slice of heaven! The quality of ingredients and the perfect crust make this place my go-to for pizza night.",
					author: "Brock Lavergne",
				},
				{
					text: "I recently discovered UpperCrust Pizza, and it's been a delightful surprise since they opened! The flavors are always on point, and their creative toppings keep me coming back for more. It's quickly become the best pizza in town, hands down!",
					author: "Dean McNeil",
				},
				{
					text: "I recently tried the pizza from UpperCrust Pizza, and it was love at first bite! The combination of fresh ingredients and the perfect blend of cheeses made for a truly memorable pizza experience. I can't wait to order again!",
					author: "Timothy Buchak",
				},
				{
					text: "I've traveled far and wide in search of the perfect pizza, and I finally found it at UpperCrust Pizza. Their pizzas are consistently delicious, and the friendly staff adds to the overall great dining experience. Highly recommended!",
					author: "Richard Davis",
				},
				{
					text: "As a pizza enthusiast, I'm thrilled to have discovered UpperCrust Pizza. The authenticity and flavor in every pie are unmatched. I've introduced all my friends to this hidden gem, and we can't get enough of their incredible pizzas. Thank you for satisfying our pizza cravings!",
					author: "Daniel Commins",
				},
			],
			timer: null,
		};
	},

	mounted() {
		this.startSlide();
	},

	methods: {
		startSlide() {
			clearInterval(this.timer);
			this.timer = setInterval(this.next, 5000);
		},

		prev() {
			this.startSlide();
			if (this.currentIndex === 0) {
				this.currentIndex = this.testimonials.length - 1;
			} else {
				this.currentIndex--;
			}
		},
		next() {
			this.startSlide();
			if (this.currentIndex === this.testimonials.length - 1) {
				this.currentIndex = 0;
			} else {
				this.currentIndex++;
			}
		},
	},
};
</script>

<style scoped>
div.testimonial-carousel {
	background-color: var(--white-color);
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	margin: 25px;
	border-radius: var(--section-border-radius);
	border: 5px solid var(--dark-color);
	padding: 10px 30px;
	text-align: justify;
	/* min-height: 45%; */
	color: var(--dark-color);
	flex: 1;
}

div#quotation-marks {
	font-size: 2rem;
	color: var(--dark-color);
	padding-bottom: 10px;
}

div.testimonial-text-wrapper {
	height: 85px;
	max-width: 40em;
	display: flex;
	flex-direction: column;
	justify-content: center;
	overflow: hidden;
}

p.testimonial-text {
	overflow: hidden;
	display: -webkit-box;
	-webkit-line-clamp: 4;
	-webkit-box-orient: vertical;
	line-height: 1.3;
}

p.testimonial-author {
	padding: 15px 0;
	font-style: italic;
	font-weight: bold;
}

div.carousel-buttons {
	font-size: 1.5rem;
	--arrow-button-padding: 15px;
	display: flex;
	align-items: center;
	justify-content: center;
	padding-bottom: 5px;
}

div.carousel-buttons i {
	color: var(--dark-color);
}

div.carousel-buttons i:first-child {
	cursor: pointer;
	padding-right: var(--arrow-button-padding);
}
div.carousel-buttons i:last-child {
	cursor: pointer;
	padding-left: var(--arrow-button-padding);
}

div.carousel-buttons i.carousel-dot {
	font-size: 0.5rem;
	color: var(--dark-color);
	padding: 0 3px;
}

@media only screen and (min-width: 768px) {
	div.testimonial-carousel {
		margin-top: 0;
		margin-left: 0;
		margin-right: 0;
		border-radius: 0;
		border-bottom-right-radius: var(--section-border-radius);
		border: 0;
		border-top: 10px solid var(--dark-color);
		margin-bottom: 0;
	}
}

@media only screen and (min-height: 768px) and (max-width: 500px) {
	div.testimonial-text-wrapper {
		height: 200px;
	}

	p.testimonial-text {
		-webkit-line-clamp: 9;
	}
}
</style>
