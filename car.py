class Car():
	def _int_(self,car_name='BMW',tank=0,oilConsumption=0):
		self.car_name=car_name
		self.tank=tank
		self.oilConsumption=oilConsumption
	def Gas_car(self,gas):
		self.tank+=gas
	def Run_car(self):
		if self.tank>0:
			print("The car can run!!!")
		elif self.tank==0:
                        print("The car can`t run!!!")




                
                    
