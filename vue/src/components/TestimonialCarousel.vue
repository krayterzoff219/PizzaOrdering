<template>
	<div class="testimonial-carousel">
		<div id="quotation-marks"><i class="fa-solid fa-quote-left"></i></div>
		<template v-for="(testimonial, index) in testimonials">
			<p
				:key="`${index}-text`"
				v-show="index === currentIndex"
				class="testimonial-text">
				{{ testimonial.text }}
			</p>
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
					text: "OMG, this pizza was sooo good! I got the mushroom pizza. I added Italian sausage and the hot honey drizzle- don't sleep on the hot honey drizzle! It was such a nice addition to my pizza that I've never had before. It added a sweet spiciness to the already rich and flavorful pizza.",
					author: "Brock Lavergne",
				},
				{
					text: "The best pizza I've tried here in Texas! 10/10. The service was amazing, the cashier was friendly & gave us suggestions to our liking. Family friendly, they have games all over the establishment so you can play and hang out with your loved ones.",
					author: "Dean McNeil",
				},
				{
					text: "This place is amazing the atmosphere always great the food is great. We love their mushroom pizza and fennel arugula salad.",
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

p.testimonial-text {
	max-width: 40em;
	height: 85px;
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
</style>
