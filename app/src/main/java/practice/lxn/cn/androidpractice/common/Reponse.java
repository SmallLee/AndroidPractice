package practice.lxn.cn.androidpractice.common;

/**
 *
 */

public class Reponse {

    /**
     * message : SUCCESS
     * data : {"bookingDate":1523169390,"bookingEndAddr":"天通苑(地铁站)","bookingEndPointLa":"40.08147675901011","bookingEndPointLo":"116.41922627615999","bookingStartAddr":"叶青大厦-D座","bookingStartPointLa":"40.018665","bookingStartPointLo":"116.476246","cancelFee":0,"createTime":1523169391060,"edjCityId":1,"estimatedAmount":126,"gpsType":"1","groupIds":"41","id":649,"imei":"865066038902701","isNew":"0","orderCurStatus":0,"orderNo":"B1523169391740549","orderType":1,"partnerOrderNo":"EDJ15231693899871955","payAmount":0,"payFlag":0,"payWay":0,"riderPhone":"18201431955","sqyeCityId":44}
     * code : 0
     */

    private String message;
    private DataBean data;
    private int code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class DataBean {
        /**
         * bookingDate : 1523169390
         * bookingEndAddr : 天通苑(地铁站)
         * bookingEndPointLa : 40.08147675901011
         * bookingEndPointLo : 116.41922627615999
         * bookingStartAddr : 叶青大厦-D座
         * bookingStartPointLa : 40.018665
         * bookingStartPointLo : 116.476246
         * cancelFee : 0.0
         * createTime : 1523169391060
         * edjCityId : 1
         * estimatedAmount : 126.0
         * gpsType : 1
         * groupIds : 41
         * id : 649
         * imei : 865066038902701
         * isNew : 0
         * orderCurStatus : 0
         * orderNo : B1523169391740549
         * orderType : 1
         * partnerOrderNo : EDJ15231693899871955
         * payAmount : 0.0
         * payFlag : 0
         * payWay : 0
         * riderPhone : 18201431955
         * sqyeCityId : 44
         */

        private int bookingDate;
        private String bookingEndAddr;
        private String bookingEndPointLa;
        private String bookingEndPointLo;
        private String bookingStartAddr;
        private String bookingStartPointLa;
        private String bookingStartPointLo;
        private double cancelFee;
        private long createTime;
        private int edjCityId;
        private double estimatedAmount;
        private String gpsType;
        private String groupIds;
        private int id;
        private String imei;
        private String isNew;
        private int orderCurStatus;
        private String orderNo;
        private int orderType;
        private String partnerOrderNo;
        private double payAmount;
        private int payFlag;
        private int payWay;
        private String riderPhone;
        private int sqyeCityId;

        public int getBookingDate() {
            return bookingDate;
        }

        public void setBookingDate(int bookingDate) {
            this.bookingDate = bookingDate;
        }

        public String getBookingEndAddr() {
            return bookingEndAddr;
        }

        public void setBookingEndAddr(String bookingEndAddr) {
            this.bookingEndAddr = bookingEndAddr;
        }

        public String getBookingEndPointLa() {
            return bookingEndPointLa;
        }

        public void setBookingEndPointLa(String bookingEndPointLa) {
            this.bookingEndPointLa = bookingEndPointLa;
        }

        public String getBookingEndPointLo() {
            return bookingEndPointLo;
        }

        public void setBookingEndPointLo(String bookingEndPointLo) {
            this.bookingEndPointLo = bookingEndPointLo;
        }

        public String getBookingStartAddr() {
            return bookingStartAddr;
        }

        public void setBookingStartAddr(String bookingStartAddr) {
            this.bookingStartAddr = bookingStartAddr;
        }

        public String getBookingStartPointLa() {
            return bookingStartPointLa;
        }

        public void setBookingStartPointLa(String bookingStartPointLa) {
            this.bookingStartPointLa = bookingStartPointLa;
        }

        public String getBookingStartPointLo() {
            return bookingStartPointLo;
        }

        public void setBookingStartPointLo(String bookingStartPointLo) {
            this.bookingStartPointLo = bookingStartPointLo;
        }

        public double getCancelFee() {
            return cancelFee;
        }

        public void setCancelFee(double cancelFee) {
            this.cancelFee = cancelFee;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getEdjCityId() {
            return edjCityId;
        }

        public void setEdjCityId(int edjCityId) {
            this.edjCityId = edjCityId;
        }

        public double getEstimatedAmount() {
            return estimatedAmount;
        }

        public void setEstimatedAmount(double estimatedAmount) {
            this.estimatedAmount = estimatedAmount;
        }

        public String getGpsType() {
            return gpsType;
        }

        public void setGpsType(String gpsType) {
            this.gpsType = gpsType;
        }

        public String getGroupIds() {
            return groupIds;
        }

        public void setGroupIds(String groupIds) {
            this.groupIds = groupIds;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImei() {
            return imei;
        }

        public void setImei(String imei) {
            this.imei = imei;
        }

        public String getIsNew() {
            return isNew;
        }

        public void setIsNew(String isNew) {
            this.isNew = isNew;
        }

        public int getOrderCurStatus() {
            return orderCurStatus;
        }

        public void setOrderCurStatus(int orderCurStatus) {
            this.orderCurStatus = orderCurStatus;
        }

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public int getOrderType() {
            return orderType;
        }

        public void setOrderType(int orderType) {
            this.orderType = orderType;
        }

        public String getPartnerOrderNo() {
            return partnerOrderNo;
        }

        public void setPartnerOrderNo(String partnerOrderNo) {
            this.partnerOrderNo = partnerOrderNo;
        }

        public double getPayAmount() {
            return payAmount;
        }

        public void setPayAmount(double payAmount) {
            this.payAmount = payAmount;
        }

        public int getPayFlag() {
            return payFlag;
        }

        public void setPayFlag(int payFlag) {
            this.payFlag = payFlag;
        }

        public int getPayWay() {
            return payWay;
        }

        public void setPayWay(int payWay) {
            this.payWay = payWay;
        }

        public String getRiderPhone() {
            return riderPhone;
        }

        public void setRiderPhone(String riderPhone) {
            this.riderPhone = riderPhone;
        }

        public int getSqyeCityId() {
            return sqyeCityId;
        }

        public void setSqyeCityId(int sqyeCityId) {
            this.sqyeCityId = sqyeCityId;
        }
    }
}
