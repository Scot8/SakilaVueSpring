let options = {
    data: () => {
        return {
            title: "Sakila API",
            resourceData: {},
            resourceType: "",
            headings: [],
            content: [],
            page: 0,
            pageSize: 10,

            // TODO - Add page info data here
        }
    },
    async created() {
        try {

            this.fetchResource("actors")
        }
        catch (error) {
            alert(error)
        }
    },
    methods: {
        async fetchResource(resource) {

            this.resourceType = resource
            try {
                let response = await fetch(
                    // TODO- Add page and size query parameters to URI here 
                    "http://localhost:8080/api/" + resource + "?page=" + this.page + "&pageSize=" + this.pageSize
                )
                let json = await response.json()
                this.content = json.content
                this.resourceData = json
                this.headings = Object.keys(this.content[0])
            } catch (error) {
                alert(error)
            }
        },
        // TODO - Add handler for navigation buttons here 
        async clickFirst() {
            this.page = 0;
            this.fetchResource(this.resourceType)
        },
        async clickNext() {

            this.page++;
            this.fetchResource(this.resourceType)
        },
        async clickPrev() {
            this.page--;
            this.fetchResource(this.resourceType)
        },
        async clickLast() {
            this.page = this.resourceData.totalPages - 1;
            this.fetchResource(this.resourceType)
        },

        async restart() {
            //restarting page number and pageSize when clicked on a button
            this.page = 0;
            this.pageSize = 5;
            this.fetchResource(this.resourceType)

        },
        changePageSize() {
            this.pageSize = document.getElementById("pageSize").value;
            console.log(this.pageSize)
            this.fetchResource(this.resourceType)
        }
    },
}
let app = Vue.createApp(options)
app.mount("#app")
