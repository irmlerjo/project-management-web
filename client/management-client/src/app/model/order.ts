import { FixedPriceCostReport } from "./fixedpricecostreport";
import { PerHourCostReport } from "./perhourcostreport";

export interface Order {
    id: string,
    projectId:string,
    name:string,
    description:string,
    fixedPriceCostReport:FixedPriceCostReport,
    perHourCostReport:PerHourCostReport,
	deliveryDate:Date,
    plannedHourlyBudget:number
    currentHours?:number
}