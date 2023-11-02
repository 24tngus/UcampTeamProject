<template>
  <Header />
  <body style="margin: 0; padding: 0;">
  <!-- HEADER -->
  <table border="0" cellpadding="0" cellspacing="0" width="100%">
    <tr>
      <td bgcolor="#EBEBEB">
        <div align="center" >
          <table border="0" cellpadding="0" cellspacing="0" width="580" class="responsive-table">
            <br>
            <tr>
              <td>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <!-- CONFIRMATION COPY -->
                  <tr>
                    <td bgcolor="#43515E" style="padding: 50px 0 50px 0;" class="pad-header">
                      <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td align="center" style="font-size: 20px; font-family: 'Open Sans', Helvetica, Arial, sans-serif; color: #EBEBEB; font-weight: 300;" class="pad-header-copy">
                            예약금 결제 완료 영수증
                          </td>
                        </tr>
                        <tr>
                          <td align="center" style="font-size: 42px; font-family: 'Open Sans', Helvetica, Arial, sans-serif; color: #EBEBEB; font-weight: 300;" class="pad-header-copy">
                            {{ paymentData.storename }} <br> 예약 완료
                          </td>
                        </tr>
                      </table>
                    </td>
                  </tr>
                </table>
              </td>
            </tr>
          </table>
        </div>
      </td>
    </tr>
  </table>

  <!-- RESERVATION DETAILS -->
  <table border="0" cellpadding="0" cellspacing="0" width="100%">
    <tr>
      <td bgcolor="#EBEBEB" align="center" style="padding: 0 15px 0 15px;">
        <table border="0" cellpadding="0" cellspacing="0" width="580" class="responsive-table">
          <tr>
            <td bgcolor="#ffffff">
              <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <!-- RESERVATION DEETS -->
                <tr>
                  <td style="padding: 30px 30px 0 30px;">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr><td align="left" style="padding: 0 0 15px 0; font-size: 20px; font-family: 'Open Sans', Helvetica, Arial, sans-serif; color: #43515E; font-weight: 300;">
                        결제 내역 상세
                      </td></tr>
                      <!-- CHECK-OUT -->
                      <tr>
                        <td>
                          <table cellspacing="0" cellpadding="0" border="0" width="100%">
                            <tr>
                              <td valign="top" style="padding: 0 0 5px 0;">
                                <!-- LEFT COLUMN -->
                                <table cellpadding="0" cellspacing="0" border="0" width="26%" align="left" class="responsive-table">
                                  <tr>
                                    <td align="center" style="padding: 0 0 0 0; font-family: 'Open Sans', Helvetica, Arial, sans-serif; color: #999999; font-weight: 600; font-size: 12px; line-height: 22px; text-align: left;" bgcolor="#ffffff" class="flex-p-bold">
                                      예약자 정보 :
                                    </td>
                                  </tr>
                                </table>
                                <!-- RIGHT COLUMN -->
                                <table cellpadding="0" cellspacing="0" border="0" width="70%" align="right" class="responsive-table">
                                  <tr>
                                    <td align="center" style="padding: 0 0 0 0; font-family: Arial, sans-serif; color: #333333; font-family: 'Open Sans', Helvetica, Arial, sans-serif; color: #00b1b1; font-weight: 400; font-size: 12px; line-height: 22px; text-align: left;" bgcolor="#ffffff" class="flex-p">
                                      {{ paymentData.userid }}
                                    </td>
                                  </tr>
                                </table>
                              </td>
                            </tr>
                          </table>
                        </td>
                      </tr>
                      <!-- CHECK-IN -->
                      <tr><td>
                        <table cellspacing="0" cellpadding="0" border="0" width="100%">
                          <tr><td valign="top" style="padding: 0 0 5px 0;">
                            <!-- LEFT COLUMN -->
                            <table cellpadding="0" cellspacing="0" border="0" width="26%" align="left" class="responsive-table">
                              <tr><td align="center" style="padding: 0 0 0 0; font-family: 'Open Sans', Helvetica, Arial, sans-serif; color: #999999; font-weight: 600; font-size: 12px; line-height: 22px; text-align: left;" bgcolor="#ffffff" class="flex-p-bold">
                                예약 장소 :
                              </td></tr>
                            </table>
                            <!-- RIGHT COLUMN -->
                            <table cellpadding="0" cellspacing="0" border="0" width="70%" align="right" class="responsive-table">
                              <tr><td align="center" style="padding: 0 0 0 0; font-family: Arial, sans-serif; color: #333333; font-family: 'Open Sans', Helvetica, Arial, sans-serif; color: #00b1b1; font-weight: 400; font-size: 12px; line-height: 22px; text-align: left;" bgcolor="#ffffff" class="flex-p">
                                {{ paymentData.storename }}
                              </td></tr>
                            </table>
                          </td></tr>
                        </table>
                      </td></tr>
                      <!-- NUMBER OF ROOMS -->
                      <tr>
                        <td>
                          <table cellspacing="0" cellpadding="0" border="0" width="100%">
                            <tr>
                              <td valign="top" style="padding: 0 0 5px 0;">
                                <!-- LEFT COLUMN -->
                                <table cellpadding="0" cellspacing="0" border="0" width="26%" align="left" class="responsive-table">
                                  <tr>
                                    <td align="center" style="padding: 0 0 0 0; font-family: 'Open Sans', Helvetica, Arial, sans-serif; color: #999999; font-weight: 600; font-size: 12px; line-height: 22px; text-align: left;" bgcolor="#ffffff" class="flex-p-bold">
                                      결제 정보 :
                                    </td>
                                  </tr>
                                </table>
                                <!-- RIGHT COLUMN -->
                                <table cellpadding="0" cellspacing="0" border="0" width="70%" align="right" class="responsive-table">
                                  <tr>
                                    <td align="center" style="padding: 0 0 0 0; font-family: Arial, sans-serif; color: #333333; font-family: 'Open Sans', Helvetica, Arial, sans-serif; color: #999999; font-weight: 400; font-size: 12px; line-height: 22px; text-align: left;" bgcolor="#ffffff" class="flex-p">
                                      {{ paymentData.paymentid }}
                                    </td>
                                  </tr>
                                </table>
                              </td>
                            </tr>
                          </table>
                        </td>
                      </tr>
                      <!-- ROOM TYPE -->
                      <tr>
                        <td>
                          <table cellspacing="0" cellpadding="0" border="0" width="100%">
                            <tr>
                              <td valign="top" style="padding: 0 0 0 0;">
                                <!-- LEFT COLUMN -->
                                <table cellpadding="0" cellspacing="0" border="0" width="26%" align="left" class="responsive-table">
                                  <tr>
                                    <td align="center" style="padding: 0 0 0 0; font-family: 'Open Sans', Helvetica, Arial, sans-serif; color: #999999; font-weight: 600; font-size: 12px; line-height: 22px; text-align: left;" bgcolor="#ffffff" class="flex-p-bold">
                                      결제 시간 :
                                    </td>
                                  </tr>
                                </table>
                                <!-- RIGHT COLUMN -->
                                <table cellpadding="0" cellspacing="0" border="0" width="70%" align="right" class="responsive-table">
                                  <tr>
                                    <td align="center" style="padding: 0 0 0 0; font-family: Arial, sans-serif; color: #333333; font-family: 'Open Sans', Helvetica, Arial, sans-serif; color: #999999; font-weight: 400; font-size: 12px; line-height: 22px; text-align: left;" bgcolor="#ffffff" class="flex-p">
                                      {{ formattedDate }}
                                    </td>
                                  </tr>
                                </table>
                              </td>
                            </tr>
                          </table>
                        </td>
                      </tr>
                      <!-- NUMBER OF ROOMS -->
                      <tr>
                        <td>
                          <table cellspacing="0" cellpadding="0" border="0" width="100%">
                            <tr>
                              <td valign="top" style="padding: 0 0 5px 0;">
                                <!-- LEFT COLUMN -->
                                <table cellpadding="0" cellspacing="0" border="0" width="26%" align="left" class="responsive-table">
                                  <tr>
                                    <td align="center" style="padding: 0 0 0 0; font-family: 'Open Sans', Helvetica, Arial, sans-serif; color: #999999; font-weight: 600; font-size: 12px; line-height: 22px; text-align: left;" bgcolor="#ffffff" class="flex-p-bold">
                                      결제 사이트 :
                                    </td>
                                  </tr>
                                </table>
                                <!-- RIGHT COLUMN -->
                                <table cellpadding="0" cellspacing="0" border="0" width="70%" align="right" class="responsive-table">
                                  <tr>
                                    <td align="center" style="padding: 0 0 0 0; font-family: Arial, sans-serif; color: #333333; font-family: 'Open Sans', Helvetica, Arial, sans-serif; color: #999999; font-weight: 400; font-size: 12px; line-height: 22px; text-align: left;" bgcolor="#ffffff" class="flex-p">
                                      VeganRoadMap
                                    </td>
                                  </tr>
                                </table>
                              </td>
                            </tr>
                          </table>
                        </td>
                      </tr>
                    </table>
                  </td>
                </tr>
                <!-- DASHED LINE -->
                <tr>
                  <td style="padding: 10px 30px 30px 30px;">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td align="center" style="padding: 15px 0 0 0; font-size: 16px; line-height: 1px; font-family: Helvetica, Arial, sans-serif; color: #999999; border-bottom: 1px dashed #999999;" class="padding-copy">
                          &nbsp;
                        </td>
                      </tr>
                    </table>
                  </td>
                </tr>

                <!-- ROOM CHARGES -->
                <tr>
                  <td style="padding: 0 30px 0 30px;">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td align="left" style="padding: 0 0 15px 0; font-size: 20px; font-family: 'Open Sans', Helvetica, Arial, sans-serif; color: #43515E; font-weight: 300; line-height: 22px; text-align: left;">
                          예약금 안내
                        </td>
                      </tr>
                      <!-- ROOM 1 -->
                      <tr>
                        <td>
                          <table cellspacing="0" cellpadding="0" border="0" width="100%">
                            <tr>
                              <td valign="top" style="padding: 0 0 0 0;">
                                <!-- LEFT COLUMN -->
                                <table cellpadding="0" cellspacing="0" border="0" width="26%" align="left" class="responsive-table">
                                  <tr>
                                    <td align="center" style="padding: 0 0 0 0; font-family: 'Open Sans', Helvetica, Arial, sans-serif; color: #999999; font-weight: 600; font-size: 12px; line-height: 22px; text-align: left;" bgcolor="#ffffff" class="flex-room-charge">
                                      Reservation :
                                    </td>
                                  </tr>
                                </table>
                              </td>
                            </tr>
                            <!-- ROOM CHARGES -->
                            <tr>
                              <td>
                                <table cellspacing="0" cellpadding="0" border="0" width="100%">
                                  <!-- NIGHTLY CHARGES -->
                                  <tr>
                                    <td valign="top" style="padding: 0 0 0 0;">
                                      <!-- LEFT COLUMN -->
                                      <table cellpadding="0" cellspacing="0" border="0" width="47%" align="left" class="responsive-table">
                                        <tr>
                                          <td align="center" style="padding: 0 0 0 10px; font-family: 'Open Sans', Helvetica, Arial, sans-serif; color: #999999; font-weight: 600; font-size: 12px; line-height: 22px; text-align: left;" bgcolor="#ffffff" class="flex-room-charge">
                                            Deposit
                                          </td>
                                        </tr>
                                      </table>
                                      <!-- RIGHT COLUMN -->
                                      <table cellpadding="0" cellspacing="0" border="0" width="47%" align="right" class="responsive-table">
                                        <tr>
                                          <td align="center" style="padding: 0 0 0 10px; font-family: Arial, sans-serif; color: #333333; font-family: 'Open Sans', Helvetica, Arial, sans-serif; color: #999999; font-weight: 400; font-size: 12px; line-height: 22px; text-align: left;" bgcolor="#ffffff" class="flex-p">

                                          </td>
                                        </tr>
                                      </table>
                                    </td>
                                  </tr>
                                  <!-- CHARGE 1 -->
                                  <tr>
                                    <td valign="top" style="padding: 0 0 0 0;">
                                      <!-- LEFT COLUMN -->
                                      <table cellpadding="0" cellspacing="0" border="0" width="67%" align="left" class="responsive-table">
                                        <tr>
                                          <td align="center" style="padding: 0 0 0 10px; font-family: 'Open Sans', Helvetica, Arial, sans-serif; color: #999999; font-weight: 400; font-size: 12px; line-height: 22px; text-align: left;" bgcolor="#ffffff" class="flex-p-desc_charges">
                                            {{paymentData.storename}}
                                          </td>
                                        </tr>
                                      </table>
                                      <!-- RIGHT COLUMN -->
                                      <table cellpadding="0" cellspacing="0" border="0" width="30%" align="right" class="responsive-table">
                                        <tr>
                                          <td align="center" style="padding: 0 0 0 0; font-family: Arial, sans-serif; color: #333333; font-family: 'Open Sans', Helvetica, Arial, sans-serif; color: #999999; font-weight: 600; font-size: 12px; line-height: 22px; text-align: right;" bgcolor="#ffffff" class="flex-p-charges">
                                            ₩ {{paymentData.price}}
                                          </td>
                                        </tr>
                                      </table>
                                    </td>
                                  </tr>
                                </table>
                              </td>
                            </tr>
                          </table>
                        </td>
                      </tr>
                      <br><br>
                      <!-- TOTAL -->
                      <tr>
                        <td align="right" style="padding: 0 0 0 0; font-size: 36px; font-family: 'Open Sans', Helvetica, Arial, sans-serif; color: #00b1b1; font-weight: 100;" class="align-total-charge">
                          ₩ {{paymentData.price}}
                        </td>
                      </tr>
                      <!-- TOTAL TITLE -->
                      <tr>
                        <td align="right" style="font-family: 'Open Sans', Helvetica, Arial, sans-serif; color: #999999; font-weight: 600; font-size: 12px; line-height: 22px;" class="align-total-charge">
                          Total (including tax recovery charges and service fees)
                        </td>
                      </tr>
                    </table>
                  </td>
                </tr>
                <!-- DASHED LINE -->
                <tr>
                  <td style="padding: 10px 30px 30px 30px;">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td align="center" style="padding: 15px 0 0 0; font-size: 16px; line-height: 1px; font-family: Helvetica, Arial, sans-serif; color: #999999; border-bottom: 1px dashed #999999;" class="padding-copy">
                          &nbsp;
                        </td>
                      </tr>
                    </table>
                  </td>
                </tr>
                <!-- PAYMENT INFORMATION -->
                <tr>
                  <td style="padding: 0 30px 0 30px;">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td align="left" style="padding: 0 0 15px 0; font-size: 20px; font-family: 'Open Sans', Helvetica, Arial, sans-serif; color: #43515E; font-weight: 300;">
                          예약금 환불 안내
                        </td>
                      </tr>
                      <!-- BILLING NAME -->
                      <tr>
                        <td>
                          <table cellspacing="0" cellpadding="0" border="0" width="100%">
                            <tr>
                              <td valign="top" style="padding: 0 0 5px 0;">
                                <!-- LEFT COLUMN -->
                                <table cellpadding="0" cellspacing="0" border="0" width="26%" align="left" class="responsive-table">
                                  <tr>
                                    <td align="center" style="padding: 0 0 0 0; font-family: 'Open Sans', Helvetica, Arial, sans-serif; color: #999999; font-weight: 600; font-size: 12px; line-height: 22px; text-align: left;" bgcolor="#ffffff" class="flex-p-bold">
                                      사이트 이름 :
                                    </td>
                                  </tr>
                                </table>
                                <!-- RIGHT COLUMN -->
                                <table cellpadding="0" cellspacing="0" border="0" width="70%" align="right" class="responsive-table">
                                  <tr>
                                    <td align="center" style="padding: 0 0 0 0; font-family: Arial, sans-serif; color: #333333; font-family: 'Open Sans', Helvetica, Arial, sans-serif; color: #999999; font-weight: 400; font-size: 12px; line-height: 22px; text-align: left;" bgcolor="#ffffff" class="flex-p">
                                      VeganRoadMap
                                    </td>
                                  </tr>
                                </table>
                              </td>
                            </tr>
                          </table>
                        </td>
                      </tr>
                      <!-- CARD TYPE -->
                      <tr>
                        <td>
                          <table cellspacing="0" cellpadding="0" border="0" width="100%">
                            <tr>
                              <td valign="top" style="padding: 0 0 5px 0;">
                                <!-- LEFT COLUMN -->
                                <table cellpadding="0" cellspacing="0" border="0" width="26%" align="left" class="responsive-table">
                                  <tr>
                                    <td align="center" style="padding: 0 0 0 0; font-family: 'Open Sans', Helvetica, Arial, sans-serif; color: #999999; font-weight: 600; font-size: 12px; line-height: 22px; text-align: left;" bgcolor="#ffffff" class="flex-p-bold">
                                      사이트 주소 :
                                    </td>
                                  </tr>
                                </table>
                                <!-- RIGHT COLUMN -->
                                <table cellpadding="0" cellspacing="0" border="0" width="70%" align="right" class="responsive-table">
                                  <tr>
                                    <td align="center" style="padding: 0 0 0 0; font-family: Arial, sans-serif; color: #333333; font-family: 'Open Sans', Helvetica, Arial, sans-serif; color: #999999; font-weight: 400; font-size: 12px; line-height: 22px; text-align: left;" bgcolor="#ffffff" class="flex-p">
                                      http://veganroadmap.com
                                    </td>
                                  </tr>
                                </table>
                              </td>
                            </tr>
                          </table>
                        </td>
                      </tr>
                      <!-- CARD NUMBER -->
                      <tr>
                        <td>
                          <table cellspacing="0" cellpadding="0" border="0" width="100%">
                            <tr>
                              <td valign="top" style="padding: 0 0 5px 0;">
                                <!-- LEFT COLUMN -->
                                <table cellpadding="0" cellspacing="0" border="0" width="26%" align="left" class="responsive-table">
                                  <tr>
                                    <td align="center" style="padding: 0 0 0 0; font-family: 'Open Sans', Helvetica, Arial, sans-serif; color: #999999; font-weight: 600; font-size: 12px; line-height: 22px; text-align: left;" bgcolor="#ffffff" class="flex-p-bold">
                                      연락처 :
                                    </td>
                                  </tr>
                                </table>
                                <!-- RIGHT COLUMN -->
                                <table cellpadding="0" cellspacing="0" border="0" width="70%" align="right" class="responsive-table">
                                  <tr>
                                    <td align="center" style="padding: 0 0 0 0; font-family: Arial, sans-serif; color: #333333; font-family: 'Open Sans', Helvetica, Arial, sans-serif; color: #999999; font-weight: 400; font-size: 12px; line-height: 22px; text-align: left;" bgcolor="#ffffff" class="flex-p">
                                      010-6395-3745
                                    </td>
                                  </tr>
                                </table>
                              </td>
                            </tr>
                          </table>
                        </td>
                      </tr>
                      <!-- BILLING ADDRESS -->
                      <tr>
                        <td>
                          <table cellspacing="0" cellpadding="0" border="0" width="100%">
                            <tr>
                              <td valign="top" style="padding: 0 0 10px 0;">
                                <!-- LEFT COLUMN -->
                                <table cellpadding="0" cellspacing="0" border="0" width="26%" align="left" class="responsive-table">
                                  <tr>
                                    <td align="center" style="padding: 0 0 0 0; font-family: 'Open Sans', Helvetica, Arial, sans-serif; color: #999999; font-weight: 600; font-size: 12px; line-height: 22px; text-align: left;" bgcolor="#ffffff" class="flex-p-bold">
                                      환불 규정 :
                                    </td>
                                  </tr>
                                </table>
                                <!-- RIGHT COLUMN -->
                                <table cellpadding="0" cellspacing="0" border="0" width="70%" align="right" class="responsive-table">
                                  <tr>
                                    <td align="center" style="padding: 0 0 0 0; font-family: Arial, sans-serif; color: #333333; font-family: 'Open Sans', Helvetica, Arial, sans-serif; color: #999999; font-weight: 400; font-size: 12px; text-align: left;" bgcolor="#ffffff" class="flex-p">
                                                                        <span class="appleBody" style="color:#999999;">
                                                                        단순변심으로 인한 환불 요청은 결제 시점으로부터 7일 이내 가능합니다. <br />
                                                                        예약 일시 1일 이내 환불 요청시 예약금이 반환되지 않습니다. <br />
                                                                        환불 요청은 상단 연락처를 통하여 신청이 가능합니다 <br />
                                                                        </span>
                                    </td>
                                  </tr>
                                </table>
                              </td>
                            </tr>
                          </table>
                        </td>
                      </tr>
                      <br><br><br>
                      <button @click="$router.push('/reserve_usercheck')" style=" background-color: darkolivegreen; opacity: 0.5; width: 100%; border-style: solid; color: white;border-radius: 10%; border-color: white;">예약 목록</button>
                      <br><br><br>
                    </table>
                  </td>
                </tr>
              </table>
            </td>
          </tr>
        </table>
        <br>
      </td>
    </tr>
  </table>
  </body>
</template>

<script>
import router from "@/scripts/router";
import axios from "axios";
import Header from "@/components/header/Header.vue";

export default {
  components: {Header},
  data() {
    return {
      currentTime: new Date(),
      paymentid : null,
      paymentData : {},
      timeArr : [],
      createdAt : '',
    };
  },
  async mounted() {
    this.paymentid = router.currentRoute.value.params.value;

    try {
      const response = await axios.get(`/api/paymentSuccess/${this.paymentid}`, this.paymentid);

      this.paymentData = response.data;

      let combined_date = '';

      for(let i=0; i<this.paymentData.created_at.length; i++) {
        combined_date += this.paymentData.created_at[i];
      }
      console.log("combined => " + combined_date);
      this.createdAt = combined_date;
      this.timeArr = this.paymentData.created_at;

    } catch (error) {
      console.error('Error while fetching data:', error);
    }
  },
  computed: {
    formattedDate() {
      const [year, month, day, hour, minute, second] = this.timeArr;
      const date = new Date(year, month - 1, day, hour, minute, second);
      return this.formatDate(date);
    }
  },
  methods: {
    formatDate(date) {
      const year = date.getFullYear();
      const month = (date.getMonth() + 1).toString().padStart(2, '0');
      const day = date.getDate().toString().padStart(2, '0');
      const hours = date.getHours().toString().padStart(2, '0');
      const minutes = date.getMinutes().toString().padStart(2, '0');
      const seconds = date.getSeconds().toString().padStart(2, '0');

      return `${year}년 ${month}월 ${day}일 ${hours}:${minutes}:${seconds}`;
    }
  },
};
</script>