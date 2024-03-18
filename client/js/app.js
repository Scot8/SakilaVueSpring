let options = {
    data: () => {
        return {
            title: "Sakila API",
            resourceData: {},
            resourceType: "",
            headings: [],
            content: [],
        }
    },
    methods: {
        async fetchResource(resource) {
            this.resourceType = resource
            try {
                let response = await fetch(
                    "http://localhost:8080/api/" + resource
                )
                let json = await response.json()
                this.content = json.content
                this.resourceData = json
                this.headings = Object.keys(this.content[0])
            } catch (error) {
                alert(error)
            }
        },
    },
}
let app = Vue.createApp(options)
app.mount("#app")
